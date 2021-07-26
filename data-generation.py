import csv
import faker
import random

PEOPLE_COUNT = 100
MAX_BANK_ACCOUNTS_PER_PERSON = 4
MAX_HOMES_PER_PERSON = 2
MAX_CARS_PER_PERSON = 3
MAX_PHONES_PER_PERSON = 1
TRANSACTION_COUNT = 200
CALL_COUNT = 500
RELATIONSHIPS_COUNT = 1000

people = []
ssns = random.sample(range(10 ** 10, 10 ** 11), PEOPLE_COUNT)
accounts = []
account_ids = random.sample(range(10 ** 5, 10 ** 6), PEOPLE_COUNT * MAX_BANK_ACCOUNTS_PER_PERSON)
IBANs = set()
homes = []
postal_codes = random.sample(range(10 ** 9, 10 ** 10), PEOPLE_COUNT * MAX_HOMES_PER_PERSON)
cars = []
plates = random.sample(range(10 ** 4, 10 ** 5), PEOPLE_COUNT * MAX_CARS_PER_PERSON)
phones = []
numbers = random.sample(range(10 ** 8, 10 ** 9), PEOPLE_COUNT * MAX_PHONES_PER_PERSON)
ownerships = []
own_ids = random.sample(range(10 ** 5, 10 ** 6), PEOPLE_COUNT * (MAX_CARS_PER_PERSON + MAX_HOMES_PER_PERSON))
transactions = []
transaction_ids = random.sample(range(10 ** 5, 10 ** 6), TRANSACTION_COUNT)
calls = []
call_ids = random.sample(range(10 ** 5, 10 ** 6), CALL_COUNT)
relationships = []

f = faker.Faker(locale='fa-IR')

for _ in range(PEOPLE_COUNT):
    first_name = f.first_name()
    surname = f.last_name()
    ssn = ssns.pop()
    birth = f.date()
    city = f.city()
    work = f.company()
    people.append((first_name, surname, ssn, birth, city, work))
    for __ in range(random.randint(0, MAX_BANK_ACCOUNTS_PER_PERSON)):
        bank_name = random.choice(['ملی', 'ملت', 'تجارت', 'صادرات', 'سرمایه'])
        i = random.randint(10 ** 23, 10 ** 24)
        while i in IBANs:
            i = random.randint(10 ** 23, 10 ** 24)
        IBAN = 'IR{}'.format(i)
        account_id = account_ids.pop()
        accounts.append((ssn, bank_name, IBAN, account_id))
    for __ in range(random.randint(0, MAX_HOMES_PER_PERSON)):
        price = random.randint(5 * 10 ** 7, 10 ** 9)
        postal_code = postal_codes.pop()
        size = random.randint(80, 300)
        address = f.address().replace('\n', ', ')
        homes.append((ssn, price, postal_code, size, address))
        own_id = own_ids.pop()
        own_date = f.date()
        amount = random.randint(100000, 800000) * 1000
        ownerships.append((ssn, postal_code, own_id, own_date, amount))
    for __ in range(random.randint(0, MAX_CARS_PER_PERSON)):
        plate = str(plates.pop())
        plate = '{}{}{}'.format(plate[:2], random.choice(['ب', 'س', 'ط', 'ج', 'ی', 'ق', 'و', 'ر']), plate[2:])
        model = random.choice(['پراید', 'لامبورگینی', 'تیوتا', 'هیوندا', 'پژو', 'دنا', 'رانا'])
        color = f.safe_color_name()
        cars.append((plate, ssn, model, color))
        own_id = own_ids.pop()
        own_date = f.date()
        amount = random.randint(20000, 400000) * 1000
        ownerships.append((ssn, plate, own_id, own_date, amount))
    for __ in range(random.randint(0, MAX_PHONES_PER_PERSON)):
        operator = random.choice(['ایرانسل', 'رایتل', 'همراه اول'])
        number = '09{}'.format(numbers.pop())
        phones.append((ssn, number, operator))
for _ in range(TRANSACTION_COUNT):
    ac = random.sample(accounts, 2)
    account_id1 = ac[0][3]
    account_id2 = ac[1][3]
    transaction_id = transaction_ids.pop()
    date = f.date()
    amount = random.randint(100, 10 ** 6) * 1000
    transactions.append((account_id1, account_id2, transaction_id, date, amount))
for _ in range(CALL_COUNT):
    ph = random.sample(phones, 2)
    number1 = ph[0][1]
    number2 = ph[1][1]
    call_id = call_ids.pop()
    date = f.iso8601()
    duration = f.time(pattern="%H:%M")
    calls.append((number1, number2, call_id, date, duration))

for _ in range(RELATIONSHIPS_COUNT):
    p = random.sample(people, 2)
    p1 = p.pop()[2]
    p2 = p.pop()[2]
    relation = random.choice([('PARENT', 'OFFSPRING'), ('SIBLING', 'SIBLING'), ('SPOUSE', 'SPOUSE')])
    date = f.date()
    relationships.append((p1, p2, relation[0], date))
    relationships.append((p2, p1, relation[1], date))


with open('people.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['first_name', 'last_name', 'ssn', 'birthday', 'city', 'work'])
    wr.writerows(people)
with open('accounts.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['ssn', 'bank_name', 'IBAN', 'account_id'])
    wr.writerows(accounts)
with open('homes.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['ssn', 'price', 'postal_code', 'size', 'address'])
    wr.writerows(homes)
with open('cars.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['plate', 'ssn', 'model', 'color'])
    wr.writerows(cars)
with open('phones.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['ssn', 'number', 'operator'])
    wr.writerows(phones)
with open('ownerships.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['from', 'to', 'ownership_id', 'date', 'amount'])
    wr.writerows(ownerships)
with open('transactions.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['from', 'to', 'transaction_id', 'date', 'amount'])
    wr.writerows(transactions)
with open('calls.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['from', 'to', 'call_id', 'date', 'duration'])
    wr.writerows(calls)
with open('relationships.csv', 'w', encoding='utf-8') as f:
    wr = csv.writer(f, quoting=csv.QUOTE_ALL)
    wr.writerow(['from', 'to', 'relation', 'date'])
    wr.writerows(relationships)

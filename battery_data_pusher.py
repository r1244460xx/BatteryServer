import json
import random
import datetime
import requests

def random_datetime(start_year=2020, end_year=2025):
    """隨機產生 datetime(YYYY-MM-DD HH:MM:SS)"""
    start_date = datetime.datetime(start_year, 1, 1)
    end_date = datetime.datetime(end_year, 12, 31)
    delta = end_date - start_date
    random_days = random.randrange(delta.days)
    random_seconds = random.randrange(24*60*60)
    rand_date = start_date + datetime.timedelta(days=random_days, seconds=random_seconds)
    return rand_date.strftime('%Y-%m-%dT%H:%M:%S')

relay_status_choices = ["11111111", "00000000", "00001111", "11110000"]
flag_choices = ["11111111", "00000000", "00001111", "11110000"]

def generate_random_data():
    data = {
        "createTime": random_datetime(),
        "uploadTime": random_datetime(),
        "bms": {
            "capacity": random.randint(0, 100),
            "totalPower":round(random.uniform(0, 500), 2),
            "totalVoltage": round(random.uniform(0, 60), 2),
            "monitorVoltage": round(random.uniform(0, 60), 2),
            "totalCurrent":  round(random.uniform(-50, 50), 2),
            "generatorACurrent": round(random.uniform(0, 30), 2),
            "generatorBCurrent": round(random.uniform(0, 30), 2),
            "sunPowerCurrent": round(random.uniform(0, 10), 2),
            "temperature": round(random.uniform(-20, 80), 2),
            "batteryStatus": random.randint(0, 1),
            "relayStatus": random.choice(relay_status_choices),
            "flag": random.choice(flag_choices)
        },
        "yeli": {
            "leftRpm": random.randint(0, 32767),
            "leftCurrent": round(random.uniform(0, 50), 2),
            "rightRpm": random.randint(0, 32767),
            "rightCurrent": round(random.uniform(0, 50), 2)
        },
        "gps": {
            "latitude": round(random.uniform(-90, 90), 6),
            "longitude": round(random.uniform(-180, 180), 6),
            "angle": round(random.uniform(0, 360), 2),
            "speed": round(random.uniform(0, 200), 2)
        }
    }
    return data

if __name__ == "__main__":
    json = generate_random_data()
    url = "http://localhost:8080/battery"
    print(requests.post(url=url, json=json))
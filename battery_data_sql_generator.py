import random
import datetime

def random_datetime(start_year=2020, end_year=2025):
    """隨機產生 datetime(YYYY-MM-DD HH:MM:SS)"""
    start_date = datetime.datetime(start_year, 1, 1)
    end_date = datetime.datetime(end_year, 12, 31)
    delta = end_date - start_date
    random_days = random.randrange(delta.days)
    random_seconds = random.randrange(24*60*60)
    rand_date = start_date + datetime.timedelta(days=random_days, seconds=random_seconds)
    return rand_date.strftime('%Y-%m-%d %H:%M:%S')

# 欲插入的筆數
num_records = 100

# 這裡先將 INSERT 的前半段 (欄位) 統一組好
sql_prefix = """INSERT INTO battery (
    create_time, 
    upload_time,
    bms_capacity,
    bms_total_power,
    bms_total_voltage,
    bms_monitor_voltage,
    bms_total_current,
    bms_generator_a_current,
    bms_generator_b_current,
    bms_sun_power_current,
    bms_battery_temperature,
    bms_battery_status,
    bms_relay_status,
    bms_flag,
    yeli_left_rpm,
    yeli_left_current,
    yeli_right_rpm,
    yeli_right_current,
    gps_latitude,
    gps_longitude,
    gps_angle,
    gps_speed
) VALUES
"""

# 蒐集所有 VALUES (...) 片段
values_list = []

# 設計一些隨機字串範圍
relay_status_choices = ["11111111", "00000000", "00001111", "11110000"]
flag_choices = ["11111111", "00000000", "00001111", "11110000"]

for _ in range(num_records):
    create_time = random_datetime()
    # upload_time 可隨機，也可故意留 None/NULL，看需求
    upload_time = random_datetime()
    bms_capacity = random.randint(0, 100)  # TINYINT
    bms_total_power = round(random.uniform(0, 500), 2)
    bms_total_voltage = round(random.uniform(0, 60), 2)
    bms_monitor_voltage = round(random.uniform(0, 60), 2)
    bms_total_current = round(random.uniform(-50, 50), 2)
    bms_generator_a_current = round(random.uniform(0, 30), 2)
    bms_generator_b_current = round(random.uniform(0, 30), 2)
    bms_sun_power_current = round(random.uniform(0, 10), 2)
    bms_battery_temperature = round(random.uniform(-20, 80), 2)
    bms_battery_status = random.randint(0, 1)  # TINYINT
    bms_relay_status = random.choice(relay_status_choices)
    bms_flag = random.choice(flag_choices)
    yeli_left_rpm = random.randint(0, 32767)
    yeli_left_current = round(random.uniform(0, 50), 2)
    yeli_right_rpm = random.randint(0, 32767)
    yeli_right_current = round(random.uniform(0, 50), 2)
    gps_latitude = round(random.uniform(-90, 90), 6)
    gps_longitude = round(random.uniform(-180, 180), 6)
    gps_angle = round(random.uniform(0, 360), 2)
    gps_speed = round(random.uniform(0, 200), 2)

    # 生成單條 VALUES
    single_values = f"('{create_time}', '{upload_time}', {bms_capacity}, {bms_total_power}, {bms_total_voltage}, {bms_monitor_voltage}, {bms_total_current}, {bms_generator_a_current}, {bms_generator_b_current}, {bms_sun_power_current}, {bms_battery_temperature}, {bms_battery_status}, '{bms_relay_status}', '{bms_flag}', {yeli_left_rpm}, {yeli_left_current}, {yeli_right_rpm}, {yeli_right_current}, {gps_latitude}, {gps_longitude}, {gps_angle}, {gps_speed})"
    values_list.append(single_values)

# 將所有單條 VALUES 串起來 (使用逗號分隔)，形成完整 SQL
full_sql = sql_prefix + ",\n".join(values_list) + ";"

print(full_sql)

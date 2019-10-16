import csv

csvFile = open("test_SFLow_data.csv","r")
reader = csv.reader(csvFile)

for item in reader:
    print(item)

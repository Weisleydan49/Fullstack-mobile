from fastapi import fastAPI
temp = input("Enter the temperature in celsius: ")
if int(temp) >= 45:
    print("It's a hot day.")
    print("Drink plenty of water.")
elif int(temp) <= 20:
    print("It's a cold day.")
    print("Wear warm clothes.")
else:
    print("It's a lovely day")
def checkTop(top, calories):
    if top[0] < calories:
        top[2] = top[1]
        top[1] = top[0]
        top[0] = calories
    elif top[1] < calories:
        top[2] = top[1]
        top[1] = calories
    elif top[2] < calories:
        top[2] = calories


file = open("inputs/day1.txt", "r")
countCalories = 0
topCalories = [0, 0, 0]
s = file.readline()
while s != "":
    if s != "\n":
        countCalories += int(s)
    else:
        checkTop(topCalories, countCalories)
        countCalories = 0
    s = file.readline()

print("MAXCALORIES = ", topCalories[0], "\n")
print("TOP 3", topCalories)
print("\nTOTAL TOP: ", topCalories[0] + topCalories[1] + topCalories[2])

file.close()

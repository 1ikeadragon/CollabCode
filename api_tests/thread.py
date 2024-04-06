import requests
import threading

url = "http://127.1:8080/exec"
headers = {'Content-Type': 'application/json'}

data1 = {
    "lang": "python",
    "code": "def bubbleSort(arr):\n    n = len(arr)\n    # optimize code, so if the array is already sorted, it doesn't need\n    # to go through the entire process\n    # Traverse through all array elements\n    for i in range(n-1):\n\n        # range(n) also work but outer loop will\n        # repeat one time more than needed.\n        # Last i elements are already in place\n        swapped = False\n        for j in range(0, n-i-1):\n\n            # traverse the array from 0 to n-i-1\n            # Swap if the element found is greater\n            # than the next element\n            if arr[j] > arr[j + 1]:\n                swapped = True\n                arr[j], arr[j + 1] = arr[j + 1], arr[j]\n\n        if not swapped:\n            # if we haven't needed to make a single swap, we\n            # can just exit the main loop.\n            return\n\n\n# Driver code to test above\narr = [64, 34, 25, 12, 22, 11, 90]\n\nbubbleSort(arr)\n\nprint(\"Sorted array is:\")\nfor i in range(len(arr)):\n    print(\"% d\" % arr[i], end=\" \")"
}

data2 = {
    "lang": "python",
    "code": "def insertionSort(arr):\n    n = len(arr)  # Get the length of the array\n      \n    if n <= 1:\n        return  # If the array has 0 or 1 element, it is already sorted, so return\n \n    for i in range(1, n):  # Iterate over the array starting from the second element\n        key = arr[i]  # Store the current element as the key to be inserted in the right position\n        j = i-1\n        while j >= 0 and key < arr[j]:  # Move elements greater than key one position ahead\n            arr[j+1] = arr[j]  # Shift elements to the right\n            j -= 1\n        arr[j+1] = key  # Insert the key in the correct position\n  \n# Sorting the array [12, 11, 13, 5, 6] using insertionSort\narr = [12, 11, 13, 5, 6]\ninsertionSort(arr)\nprint(arr)"
}

def send_post(data):
    response = requests.post(url, headers=headers, json=data)
    print(response.json())

thread1 = threading.Thread(target=send_post, args=(data1,))
thread2 = threading.Thread(target=send_post, args=(data2,))

thread1.start()
thread2.start()

thread1.join()
thread2.join()

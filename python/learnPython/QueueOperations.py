# The following shows how to implement queue basic operations

from collections import deque

queue = deque(["hi","hello","bye"])
print(queue)
queue.append("a")
print(queue)
print(queue.popleft())
print(queue)



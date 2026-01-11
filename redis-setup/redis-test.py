import redis 

r = redis.Redis(host='localhost', port=6379, db=0)

r.set('MyKey', 'Hello from the test script!')

value = r.get('MyKey')
print(value)

# convert to string 
print(value.decode('utf-8'))

# remove 
r.delete('MyKey')

# LPUSH: Push an element to the head (left) of the list
r.lpush("task_queue", "task1")

# RPUSH: Push an element to the tail (right) of the list
r.rpush("task_queue", "task2")
r.rpush("task_queue", "task3")

# LPOP: Pop (remove and return) the element at the head
task = r.lpop("task_queue")
print(task)  # b'task1'

# Optional: RPOP removes and returns the element at the tail
task = r.rpop("task_queue")
print(task)  # b'task3'



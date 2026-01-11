echo "Pulling the latest Redis Docker image..."
docker pull redis:latest

echo "Running Redis container..."
docker run -d --name redis-server -p 6379:6379 redis:latest

echo "Testing Redis server..."
docker exec -it redis-server redis-cli ping

source ./.learn/bin/activate  
.learn/bin/python3 redis-test.py


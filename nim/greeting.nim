#thi sis comment

from strutils import parseInt

echo "Whats your name"
# let is one time assignment variable.
let name: string = readLine(stdin)
if name == "":
  echo "Do not know name"
elif name == "name":
  echo "Funny name is name"
else:
  echo "Hi, ", name, "!"

case name
of "":
  echo "Do not know name"
of "name":
  echo "Funny name is name"
of "Guru":
  echo "Cool name"
else:
  echo "Hi, ", name, "!"


let value = parseInt(readLine(stdin))
case value
of 0..2,4..7:
  echo "In set"
of 3,8:
  echo "either 3 or 8"
else:
  discard


echo "Counting up "

for i in countup(1, 10):
  echo $i

  

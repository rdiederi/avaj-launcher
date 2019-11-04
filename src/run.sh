 #!/bin/bash
find . -name '*.java' > sources.txt
javac @sources.txt
javac -sourcepath @sources.txt
java za.co.rdiederi.Main $1

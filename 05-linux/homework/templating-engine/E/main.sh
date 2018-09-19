#!/bin/bash
eval $(cat $1)

cat $2 |                                                                                                                                                                            
while read LINE                                                                                                                                                                               
do 
    while [ "$prev" != "$LINE" ]
        do                                      
            prev=$LINE
            LINE=$(eval echo $(echo $LINE | sed -r 's/@(\w+)@/\$\1/g'))
        done
    echo $LINE
done
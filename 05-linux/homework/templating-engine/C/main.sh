#!/bin/bash
eval $(cat $1)

cat $2 |                                                                                                                                                                            
while read LINE                                                                                                                                                                               
do                                       
    eval echo $(echo $LINE | sed -r 's/@(\w+)@/\$\1/g')
done 
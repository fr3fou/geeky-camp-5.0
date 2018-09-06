#!/bin/bash
pesho="qbulka"
param1="stoinost"
param2="sedem"

cat $1 |                                                                                                                                                                            
while read LINE                                                                                                                                                                               
do                                       
    eval echo $(echo $LINE | sed -r 's/@(\w+)@/\$\1/g')
done 
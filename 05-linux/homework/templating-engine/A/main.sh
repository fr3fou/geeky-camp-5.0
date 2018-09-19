#!/bin/bash
param1="stoinost"
param2="sedem"
param3="osem"

cat $1 |                                                                                                                                                                            
while read LINE                                                                                                                                                                               
do                                       
    eval echo $(echo $LINE | sed -r 's/@(\w+)@/\$\1/g')
done 
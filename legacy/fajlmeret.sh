#!/bin/bash
ls -l | awk '$1=$1' | cut -d " " -f5,9 | awk ' {print $2 ,$1} ' | tr ' ' ';' > ../out.csv

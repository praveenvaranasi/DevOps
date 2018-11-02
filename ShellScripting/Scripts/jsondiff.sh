#! /bin/sh

ffile=$1
sfile=$2
wd=$(pwd)

function cleanup()
{
  [ -e ${ffile} ] || { echo "${ffile} does not exist" ; exit; }
  [ -e ${sfile} ] || { echo "${sfile} does not exist"; exit; }
  rm -f ${wd}/rf.json ${wd}/rs.json ${wd}/rr.json
}

function parse()
{
  filetobeparsed=$1
  sed -e 's/[{};]//g' -e 's/\,/ /g' ${filetobeparsed}
}

function addDifferentKeysToFile()
{
  res_arr="$1"
  echo "${res_arr[@]}" | sed -e 's/ /\n/g' > ${wd}/$2
}

function compare()
{
  arr_ff="$1"
  arr_sf="$2"
  resarr=()
  for key_ff in ${arr_ff[@]}
  do
     temp_keyf=`echo ${key_ff} | sed -e 's/"//g' | cut -d ':' -f1`
     res=
     for key_sf in ${arr_sf[@]}
     do
        temp_keysf=`echo ${key_sf} | sed -e 's/"//g' | cut -d ':' -f1`
	[[ ${temp_keyf} == ${temp_keysf} ]] && { res=1; break; }
     done
     [[ $res -eq 0 ]] &&  resarr+=("${key_ff}") 
  done
  declare -a resarr=${resarr[@]}
  addDifferentKeysToFile "${resarr[@]}" $3
}

cleanup
declare -a ffile_keys=$(parse ${ffile})
declare -a sfile_keys=$(parse ${sfile})
compare "${ffile_keys[@]}" "${sfile_keys[@]}" "rf.json"
compare "${sfile_keys[@]}" "${ffile_keys[@]}" "rs.json"
cat ${wd}/rf.json ${wd}/rs.json > ${wd}/rr.json
#sed -i ':a;N;$!ba;s/\n/,/g' ${wd}/rr.json


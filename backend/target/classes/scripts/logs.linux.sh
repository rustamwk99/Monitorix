#!/bin/bash
#echo "user agent"
#Номер строки
counter=-1
output=""
#Переменные таблицы
date=""
hostname=""
transport=""
sources=""
message=""
and="&"

chatID=""

hostnameArr=()
priorityArr=()
sourceArr=()
messageArr=()
paramsArr=()
timeArr=()

idArr=()
triggerArr=()
idItem=$(curl http://192.168.43.30:8080/scr/triggerLin | jq '.[].id')
idArr+=($idItem)
triggerItem=$(curl http://192.168.43.30:8080/scr/triggerLin | jq '.[].trigger')
triggerArr+=($triggerItem)
triggerArrSize=${#idArr[@]}




read -p "Enter Chat ID: " chatID
paramsArr+=(${chatID})
paramsArr+=("LinScriptTest")
NetAddr="/gmail"
output="$(journalctl -n 100 -o json-pretty)"
host=$(jq '._HOSTNAME' <<< ${output})
hostnameArr+=($host)
priority=$(jq '.PRIORITY' <<< ${output})
priorityArr+=($priority)
source=$(jq '.SYSLOG_IDENTIFIER' <<< ${output})
sourceArr+=($source)
message=$(jq '.MESSAGE' <<< ${output})
messageArr+=($message)
time=$(jq '.__REALTIME_TIMESTAMP' <<< ${output})
timeArr+=($time)
size=${#hostnameArr[@]}
IFS=$'\n'
for ((i=0; i<$size; i++));
do
echo ${hostnameArr[$i]//\"/}
echo ${priorityArr[$i]//\"/}
echo ${sourceArr[$i]//\"/}
echo ${messageArr[$i]//\"/}
sleep 5
	IFS=$'\n'
	for ((j=0; j<$triggerArrSize; j++));
	do
		echo ${triggerArr[$j]}
		if [[ ${triggerArr[$j]} =~ .*${messageArr[$i]//\"/*} ]] ; then
		curl https://api.telegram.org/bot1745907536:AAEhvVpDfFBymxlITCXaiyD3sCfcAdtJgvo/sendMessage?chat_id="${paramsArr[0]}"'&'text="${timeArr[$i]//\"/}'\n'""${sourceArr[$i]//\"/}'\n'""${messageArr[$i]//\"/}"
		fi
	done
#curl https://api.telegram.org/bot1745907536:AAEhvVpDfFBymxlITCXaiyD3sCfcAdtJgvo/sendMessage?chat_id="${paramsArr[0]}"'&'text="${paramsArr[1]}"
wget http://192.168.43.30:8080/scr/linux?hostname="${hostnameArr[$i]//\"/}"'&'priority="${priorityArr[$i]//\"/}"'&'source="${sourceArr[$i]//\"/}"'&'message="${messageArr[$i]//\"/}"
done

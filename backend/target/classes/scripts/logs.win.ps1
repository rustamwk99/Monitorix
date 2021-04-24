[xml]$ConfigFile = Get-Content "C:\Users\HP\Downloads\logs.win.xml"

$Events = Get-EventLog -LogName System -Newest 100
$ind = 0
$entry_type = ""
$source = ""
$instanceId = 0
$message = ""
$ct = 0
$warning = "Warning"
$params= @{chat_id="361460888";text="ScriptTest"}

$params.chat_id = $ConfigFile.Settings.BotSettings.ChatId
if ($params.chat_id -eq ""){
    $chatIdPrompt = Read-Host "Enter Chat Id:"
    $params.chat_id = $chatIdPrompt
    $ConfigFile.Settings.BotSettings.ChatId = $params.chat_id.ToString()
    $ConfigFile.Save("C:\Users\HP\Downloads\logs.win.xml")
} else{
    $chatIdTemp = Read-Host "Change Chat Id?(y/n) "
    if($chatIdTemp -eq "y".toLower()){
        $chatIdPrompt = Read-Host "Enter Chat Id:"
        $params.chat_id = $chatIdPrompt
        $ConfigFile.Settings.BotSettings.ChatId = $params.chat_id.ToString()
        $ConfigFile.Save("C:\Users\HP\Downloads\logs.win.xml")
    }
}
while($ct -lt $Events.Count){
    $triggers = Invoke-RestMethod -Uri "http://192.168.43.30:8080/scr/trigger"
    $triggers
    $ct+=1
    $ind = $Events.Get($ct).Index
    $entry_type = $Events.Get($ct).EntryType.ToString()
    if ($entry_type -eq $null)
    {
        $entry_type = "Unsigned"
    }

    $source = $Events.Get($ct).Source
    $instance_id = $Events.Get($ct).InstanceId
    $message = $Events.Get($ct).Message
    For ($i=0; $i -lt $triggers.Length; $i++){
        if ([regex]::Match($message,$triggers.Get($i).trigger).Success)
        {
            $params.text = $message
            Invoke-WebRequest -Uri https://api.telegram.org/bot1745907536:AAEhvVpDfFBymxlITCXaiyD3sCfcAdtJgvo/sendMessage -Method POST -Body $params
            echo "works"
        }}
    $message = $Events.Get($ct).Source
    Invoke-WebRequest -Uri http://192.168.43.30:8080/scr/info?index=$ind'&'description=$entry_type'&'source=$source'&'instance_id=0'&'message=$message;
    Start-Sleep -s 8
}
$ind = 0
$ct = 0
$entry_type = ""
$source = ""
$instance_id = 0
$message = ""

#triggers
#6062
#Параметры разрешений
#Сбой загрузки
#остановлен
#Попытка пользователя
#Разрешение имен
#время ожидания
#Служба //// неожиданно завершена
#Служба //// завершена из-за ошибки
#попытка автоматического восстановления
#Служба //// неожиданно прервана
#не удалось

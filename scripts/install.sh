#!/bin/bash

rm ~/Library/Application\ Support/minecraft/mods/lodecraftia-0.1.jar
cp ../build/libs/lodecraftia-0.1.jar ~/Library/Application\ Support/minecraft/mods/

scp ../build/libs/lodecraftia-0.1.jar new.russt.me:~/lodecraftia-0.1.jar
ssh -t -t new.russt.me << EOF
sudo chown minecraft:minecraft /home/russ/lodecraftia-0.1.jar
sudo mv /home/russ/lodecraftia-0.1.jar /home/minecraft/minecraft/mods/
sudo systemctl restart minecraft
exit
EOF

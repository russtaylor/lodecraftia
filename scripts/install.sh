#!/bin/bash

rm ~/Library/Application\ Support/minecraft/mods/lodecraftia-0.1.jar
cp build/libs/lodecraftia-0.1.jar ~/Library/Application\ Support/minecraft/mods/

scp build/libs/lodecraftia-0.1.jar new.russt.me:~/minecraft/mods/

#!/bin/sh
if ! command -v git &> /dev/null
then
    echo "git could not be found"
    exit
fi
git clone https://github.com/josephwalden13/Minecraft-Mod
cd Minecraft-Mod
./gradlew clean
./gradlew genIntellijRuns

#!/usr/bin/env bash

isLocal=true
if [ $# -eq 1  ];
then
  isLocal=$1
fi

isSmokeTest=true
if [ $# -eq 2  ];
then
  isSmokeTest=$2
fi

echo "*** Running locally: $isLocal. Smoke-test mode: $isSmokeTest ***"

sbt -DrunLocal=$isLocal -Dperftest.runSmokeTest=$isSmokeTest -Dperftest.labels=statement-of-liability clean gatling:test
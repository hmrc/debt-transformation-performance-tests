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

if $isLocal == "true";
then
    export INTERNAL_AUTH_TOKEN="valid-auth-token"
fi

echo "Internal Auth Token: $INTERNAL_AUTH_TOKEN"

sbt -DrunLocal=true -Dperftest.runSmokeTest=$isSmokeTest -Dperftest.labels=interest-forecasting clean "Gatling/test"

#!/bin/bash

if [[ -z "${VERSION}" ]]
then
  echo "Type the next VERSION"
  read VERSION
fi

mvn versions:set --batch-mode --file api/pom.xml -DnewVersion=${VERSION} -DgenerateBackupPoms=false
mvn versions:set --batch-mode --file app/pom.xml -DnewVersion=${VERSION} -DgenerateBackupPoms=false
mvn versions:set --batch-mode --file pom.xml -DnewVersion=${VERSION} -DgenerateBackupPoms=false

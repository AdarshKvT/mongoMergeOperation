# mongoMergeOperation
This is a Maven java project
Merge new keys with the existing document in Collection without updating entire Document.
==========(Existing Documnet)===========
{
 "name":"sasuke",
 "ability": "lightning blade"
}

==========(After merging operation)===========
{
 "name":"sasuke",
 "ability": "lightning blade",
 "squad":"7",
 "clan": "uchiha"
}

Mongo depedencies:
	<dependency>
			<groupId>org.mongodb</groupId>
			<artifactId>mongo-java-driver</artifactId>
			<version>3.6.3</version>
	</dependency>

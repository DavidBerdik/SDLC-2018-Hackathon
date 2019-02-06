# SDLC 2018 Hackathon: sudo rm -rf /
### A2: Benefits Platform Intelligent Automation

### Some Quick Info
This project was created during the twelve hour SDLC Hackathon 2018. This project is far from complete, most packages do however come with a functioning test contained in the `hackathon.sdlc.unittests` package. Although, as a team, we found ourselves quite content with the final "product" seeing as we spent much of the time learning and adapting to new libraries not introduced to us while in University. The project instructions that were provided to us at the hackathon are available [here](Instructions.pdf).

**This copy of the repository is intended to serve as an archive showing the state of the project at the end of the 12 hour development period. The project is now maintained by Duquesne University's Chapter of the Association for Computing Machinery. Any additional work on the project will take place on [their copy of the repository](https://github.com/DuquesneACM/SDLC-2018-Hackathon).**

### Packages
* hackathon.sdlc.cognitive - allows for remote requests to the Microsoft Computer Vision API.
* hackathon.sdlc.database - allows for remote connections to a predetermined database for uploads.
* hackathon.sdlc.ftp - allows for remote connections to a predetermined FTP server.
* hackathon.sdlc.pdf - utilizes Apache libraries to convert PDF documents to PNG files.
* hackathon.sdlc.frontend - creates and manages a Java Servlet in TomCat.
* hackathon.sdlc.unittests - contains classes used for testing individual packages.

### Dependencies
* [Apache PDF Box](https://pdfbox.apache.org/)
* [Apache Commons Logging](http://commons.apache.org/proper/commons-logging/)
* [Apache HTTP Components](https://hc.apache.org/index.html)
* [MySQL Java Connector](https://dev.mysql.com/downloads/connector/j/5.1.html)
* [Microsoft Computer Vision](https://westus.dev.cognitive.microsoft.com/docs/services/5adf991815e1060e6355ad44/operations/56f91f2e778daf14a499e1fa)

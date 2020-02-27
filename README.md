# SARELLA
Progetto Siw 2020

Il progetto è stato pensato per l'utilizzo tramite Apache Tomcat 9.0+ come server, Maven come building tool.
Il database è hostato in remoto, le credenziali sono in chiaro nel codice (vedi: DataSource, DBManager).

ATTENZIONE:

- Perchè il caricamento delle immagini abbia successo, è necessario specificare una directory ESISTENTE sul proprio PC, dove verranno salvate le immagini e da dove verranno caricate nelle pagine (l'intenzione è di simulare l'hosting sulla macchina di un server remoto).
    Per impostarla: 
    - src.main.java.controller.FileServlet, riga 20:
        - File file = new File("il/vostro/path/locale", filename);
    - src.main.java.controller.AddRoom, riga 61:
        - File upload = new File("il/vostro/path/locale", filename);
        
- Per poter usufruire delle funzionalità della Google API per il logging, è necessario accedere da localhost:8080 o localhost:8008.
- La password deve essere lunga almeno 6 caratteri, contenere un carattere maiuscolo, uno minuscolo e uno numerico.
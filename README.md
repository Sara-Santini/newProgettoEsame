# Bonfire Application

La Bonfire Application è in grado di eseguire una serie di richieste per soddisfare tutti gli utenti Instagram. In particolare elabora i dati in formato Json, ed effettua il download delle foto. Inoltre nel processo di scaricamento  differenzia le singole immagini dagli album attraverso la creazione di sottocartelle. Infine immagazzina una serie di dati per elaborare statistiche e filtri sulle foto scaricate. I Filtri selezionano i dati ,attraverso dei caratteri jolly, in base alle richieste dell’utente e modificano il DataSet creando cartelle opportune. Sempre con i filtri è possibile apportare delle modifiche sul proprio profilo Instagram, come aggiungere o eliminare foto. Le statistiche forniscono dati riguardanti i byte e i pixel delle foto o degli album. 
Tutto ciò viene facilitato  dall’utilizzo di Spring Boot, un  framework che consente di lanciare l’intera applicazione web, tramite protocollo http e di effettuare le richieste volute dall’utente 

**Più precisamente l’applicazione è in grado di:**
- Restituire dei metadati, formato JSON cioè elencare tutte le Foto del profilo;
- Restituire dei dati filtrati, formato JSON.
- Restituire delle statistiche sui dati di uno specifico campo.
- Restituire delle statistiche su dei dati filtrati attraverso caratteri jolly.
- Eliminare immagini

## Download:
Attraverso l’ambiente eclipse si possono eseguire le seguenti operazioni:

•	Clonare la repository dal workspace di github 

•	Eseguire il codice come SpringBoot application

•	Aprire un API testing come ad esempio postman

L’applicazione ora è pronta ed è in ascolto alla porta http://localhost8080.

**Richieste:**
Attraverso delle API REST (GET,POST o DELETE) si possono eseguire delle richieste:


TIPO | ROTTA | FUNZIONE
-- | -- | --
GET | /metadata | Restituisce un formato Json di tutta la collecton di dati
GET | /getAllStatistics | Restituisce tutte statistiche applicate alle immagini
GET | /getAverageOfBytes | Restituisce la media dei bytes delle foto
GET | /getAverageOfPixel | Restituisce la media dei pixel delle foto
GET | /getMedianOfPixels | Restituisce la mediana dei pixel delle foto
GET | /getAverageOfHashtag | Restituisce la media degli hashtahg presenti nella caption di ogni foto
GET | /getMedianOfBytes | Restituisce la mediana dei bytes delle immagini
GET | /getTotHashtag | Restituisce il totale degli hashtag tra tutte le foto del profilo
GET | /getAllFilters | Applica dei filtri alle immagini locali
GET | /getFiters | Restituisce dei filtri attraverso dei caratteri jolly
GET | /searchPhoto | Cerca una foto dato il suo id
GET | /getAllStatisticsFilters | Restituisce le statistiche sulle immagini filtrate
POST | /postImage | Permette di postare una foto
POST | /postCarouselAlbum | Permette di postare un album
DELETE | /deleteImage | Cancella una foto
DELETE | /deleteCarouselAlbum | Cancella un album

È possibile applicare dei filtri utilizzando questi caratteri jolly:

CARATTERE JOLLY | DESCRIZIONE | ESEMPIO
-- | -- | --
\| | Filtra in base all’altezza | **{ "filter": [ {"field": "\|", "param": "1000"}]}**
-| Filtra in base alla lunghezza | **{ “filter”: [{"field": "-",param": "1000" }]}**
?| Filtra le foto sopra i 100 Kb | **{ “filter”: [{"field": "?",param": "" }]}**
!| Filtra le foto sotto i 100 Kb | **{ “filter”: [{"field": "!",param": "" }]}**
#| Filtra le foto con gli hashtag | **{ “filter”: [{"field": "#",param": "" }]}**



Inoltre è possibile combinare più filtri e per fare questo è sufficiente specificare il modo in cui si vogliono combinare aggiungendo vettori di chiave/valore  .
Ad esempio

**{ "filter": [ { "field": "|", "param": "1000"} ,{"field": "-", "param": "1000"}}**

## UML

## UML Use Case Diagram

![NewModel Use Case Diagram](https://user-images.githubusercontent.com/64470414/84430752-77fe9b80-ac2a-11ea-963f-b19d36e2ee5e.jpg)

## UML Class Diagram
**Package Model**

![model](https://user-images.githubusercontent.com/64470414/84430172-90ba8180-ac29-11ea-9289-62a90faca84f.jpg)

**Package Others**

![others (2)](https://user-images.githubusercontent.com/64470414/84476489-85e60800-ac8e-11ea-9bd1-614e95267534.jpg)

**Package Controller**

![controller](https://user-images.githubusercontent.com/64470414/84430908-b09e7500-ac2a-11ea-9b0c-dcd1ed1ab25c.jpg)

**Package Statistics**

![Statistic](https://user-images.githubusercontent.com/64470414/84430970-cd3aad00-ac2a-11ea-9fb8-182295a2b902.jpg)

**Package Filters**

![filter](https://user-images.githubusercontent.com/64470414/84431036-e6435e00-ac2a-11ea-9892-992a0ba79887.jpg)

**Package ApplicationTests**

![test](https://user-images.githubusercontent.com/64470414/84431114-0d019480-ac2b-11ea-8891-d23ef7d89476.jpg)

**Package Exception**

![NewModel Class Diagram](https://user-images.githubusercontent.com/64470414/84431180-299dcc80-ac2b-11ea-891c-cf189d71527e.jpg)


## UML Sequence Diagram	

![NewModel Sequence Diagram](https://user-images.githubusercontent.com/64470414/84430014-5d77f280-ac29-11ea-9df8-ff2166523498.jpg)

AppController crea un oggetto di tipo Database, il quale inizializza un Hashset di API e effettua il download di tutte le foto e il caricamento dei medesimi dati tramite la chiamata delle classi Parsing e Download.Inoltre DataBase contiene una serie di metodi utili per la Gestione del AppController.

![:Users:sarasantini:eclipse-workspace:progetto:src:Scenario_0 sequence diagram](https://user-images.githubusercontent.com/64470414/84172478-5a8bcf00-aa7c-11ea-9a30-9b41b7c459a6.jpg)

## Software utilizzati
•	**Eclipse**- ambiente di sviluppo integrato

•	**Spring Boot**-framework per sviluppo applicazioni Java

•	**Postman**-API Testing

•	**UMLGenerator**-ambiente che genera diagrammi UML

•	**Maven**-strumento di gestione di progetti

## Autori e Contributi
•	**Arianna Nazzarelli:** JunitTests, UML Class Diagram, JavaDoc, Exception,Image,getJSON, Statistics, StatisticsService, DataBase

•	**Francesco Voto:** JParsing, API_Instagram, Fotogafia, UML Use Case Diagram, Filter, FilterService, getURL, DataBase, GUI

•	**Sara Santini:** JunitTests, UML Sequence Diagram, Controller, Exceptions, Album, 
getImageAlbumURL, Statistics, StatisticService, Database


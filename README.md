# Bonfire Application

La Bonfire Application è in grado di eseguire una serie di richieste per soddisfare tutti gli utenti Instagram. In particolare, elabora i dati in formato JSON ed effettua il download delle foto. Inoltre, nel processo di scaricamento, differenzia le singole immagini dagli album attraverso la creazione di sottocartelle. Infine, immagazzina una serie di dati per elaborare statistiche e filtri sulle foto scaricate. 
I Filtri selezionano i dati attraverso dei caratteri jolly, in base alle richieste dell’utente e modificano il DataSet, creando cartelle opportune. Sempre con i filtri è possibile apportare delle modifiche sul proprio profilo Instagram, come aggiungere o eliminare foto. 
Le statistiche forniscono dati riguardanti i byte e i pixel delle foto o degli album. 
Tutto ciò viene facilitato dall’utilizzo di SpringBoot, un framework che consente di lanciare l’intera applicazione web, tramite protocollo http e di effettuare le richieste volute dall’utente. 

**Più precisamente l’applicazione è in grado di:**
- Restituire dei metadati, formato JSON cioè elencare tutte le Foto del profilo;
- Restituire dei dati filtrati in formato JSON;
- Restituire delle statistiche sui dati di uno specifico campo;
- Restituire delle statistiche su dei dati filtrati attraverso caratteri jolly;
- Eliminare immagini.

## Download:
Attraverso l’ambiente Eclipse si possono eseguire le seguenti operazioni:

•	Clonare la repository dal workspace di github;

•	Eseguire il codice come SpringBoot application;

•	Aprire un API testing come ad esempio [Postman](https://www.postman.com/downloads/).

L’applicazione ora è pronta ed è in ascolto alla porta http://localhost8080.

All'avvio dell'applicazione compariranno tre finestre pop-up in cui si chiederà di specificare la directory nella quale salvare le immagini, il token di accesso del profilo Instagram eil sistema operativo del dispositivo. Inoltre, verranno suggeriti nelle caselle di testo degli esempi.

**Richieste:**
Attraverso delle API REST (GET, POST o DELETE) si possono eseguire delle richieste che differiscono in base alle rotte elencate di seguito:


TIPO | ROTTA | FUNZIONE
-- | -- | --
GET | /metadata | Restituisce un formato Json di tutta la collection di dati
GET | /getAllStatistics | Restituisce tutte statistiche applicate alle immagini
GET | /getAverageOfBytes | Restituisce la media dei bytes delle foto
GET | /getAverageOfPixel | Restituisce la media dei pixel delle foto
GET | /getMedianOfPixels | Restituisce la mediana dei pixel delle foto
GET | /getAverageOfHashtag | Restituisce la media degli hashtag presenti nella caption di ogni foto
GET | /getMedianOfBytes | Restituisce la mediana dei bytes delle immagini
GET | /getTotHashtag | Restituisce il totale degli hashtag tra tutte le foto del profilo
GET | /getAllFilters | Divide le immagini nel dispositivo in tre sottocartelle: WithHashtag, More100Kb, Under100Kb
GET | /getFiters | Restituisce i filtri attraverso dei caratteri jolly
GET | /searchPhoto | Cerca una foto dato il suo id
GET | /getAllStatisticsFilters | Restituisce le statistiche sulle immagini filtrate
POST | /postImage | Permette di postare una foto 
POST | /postCarouselAlbum | Permette di postare un album
DELETE | /deleteImage | Cancella una foto passandogli un id
DELETE | /deleteCarouselAlbum | Cancella un album

## Filtri

È possibile effettuare dei filtri e richiedere statistiche su di essi in base a diversi parametri utilizzando i seguenti caratteri jolly:

CARATTERE JOLLY | DESCRIZIONE | ESEMPIO
-- | -- | --
Hi\| | Filtra in base all’altezza | **{ "filter": [ {"field": "Hi\|", "param": "1000"}]}**
Wi-| Filtra in base alla lunghezza | **{ “filter”: [{"field": "Wi-",param": "1000" }]}**
Mo?| Filtra le foto sopra un numero di bytes che sarà deciso dall’utente in “param” | **{ “filter”: [{"field": "Mo?",param": "" }]}**
Un!| Filtra le foto sotto un numero di bytes che sarà deciso dall’utente in “param” | **{ “filter”: [{"field": "Un!",param": "" }]}**
Ha#| Filtra le foto con gli hashtag | **{ “filter”: [{"field": "Ha#",param": "" }]}**

Inoltre, è possibile combinare più filtri. Per fare questo, è sufficiente specificare il modo in cui si vogliono combinare aggiungendo vettori di chiave/valore in formato JSON.
Ad esempio, se volessimo filtrare le foto in base a una data altezza e a una data lunghezza dovremmo scrivere come riportato in seguito:

**{ "filter": [ { "field": "Hi|", "param": "1000"} ,{"field": "Wi-", "param": "1000"}]}**

## Statistiche

È possibile effettuare le seguenti statistiche sulle foto del nostro profilo Instagram:
•	Media dei byte, dei pixel e degli hashtag;

•	Mediana dei byte e dei pixel;

•	Varianza dei byte e dei pixel;

•	Totale degli hashtag.

Inoltre, è possibile effettuare le statistiche sulle immagini filtrate.

## UML

## UML Use Case Diagram

![NewModel Use Case Diagram](https://user-images.githubusercontent.com/64470414/84430752-77fe9b80-ac2a-11ea-963f-b19d36e2ee5e.jpg)

## UML Class Diagram

**Package Model**
![MODEL-2](https://user-images.githubusercontent.com/64470414/85554945-b2523a80-b625-11ea-92ff-cb6de913e358.jpg)

**Package Others**

![OTHERS](https://user-images.githubusercontent.com/64470414/85555014-c4cc7400-b625-11ea-8f9f-43bcefccf0ba.jpg)

**Package Controller**

![CONTROLLER E DATABASE](https://user-images.githubusercontent.com/64470414/85555075-d1e96300-b625-11ea-8940-8aa1b29c86c3.jpg)

**Package Statistics**

![Statistic-2](https://user-images.githubusercontent.com/64470414/85555126-e0d01580-b625-11ea-9fcf-23b9df6b016e.jpg)

**Package Filters**

![Filter-2](https://user-images.githubusercontent.com/64470414/85555195-f2b1b880-b625-11ea-9e91-9e73855e77c4.jpg)

**Package ApplicationTests**

![Test-2](https://user-images.githubusercontent.com/64470414/85555237-ffcea780-b625-11ea-86a0-e0851e0b6b23.jpg)

**Package Exception**

![exception](https://user-images.githubusercontent.com/64470414/85555293-0fe68700-b626-11ea-8283-545528b2aa07.jpg)

## UML Sequence Diagram	

AppController crea un oggetto di tipo Database. Quest’ultimo, inizializza un Hashset di API, effettua il download di tutte le foto e il caricamento dei medesimi dati tramite la chiamata delle classi Parsing e Download. Inoltre, DataBase contiene una serie di metodi utili per la Gestione dell’AppController.

**Download API**

![Downloadfinito](https://user-images.githubusercontent.com/64470414/85517216-55438e00-b5ff-11ea-9185-e2d702329878.jpg)

**Statistics**

![Staisticsfinito](https://user-images.githubusercontent.com/64470414/85517285-65f40400-b5ff-11ea-866b-c4f4f3d4dbc6.jpg)

**Filters**

![Filtersfinito](https://user-images.githubusercontent.com/64470414/85543871-c2b0e800-b61a-11ea-9ff2-8ac35630933c.jpg)

## Software utilizzati
•	**[Eclipse](https://www.eclipse.org/)**- ambiente di sviluppo integrato;

•	**[SpringBoot](https://spring.io/projects/spring-boot)**-framework per sviluppo applicazioni Java;

•	**[Postman](https://www.postman.com/downloads/)**-API Testing;

•	**[UMLGenerator](http://www.umldesigner.org)**-ambiente che genera diagrammi UML;

•	**[Maven](https://maven.apache.org/)**-strumento di gestione di progetti.

## Autori e Contributi

La suddivisione del lavoro è indicativa in quanto il gruppo ha collaborato per lo sviluppo di gran parte del codice.

•	**[Arianna Nazzarelli](https://github.com/AriannaNazzarelli):** JunitTests, UML Class Diagram, JavaDoc, Exception,Image,getJSON, Statistics, StatisticsService, DataBase

•	**[Sara Santini](https://github.com/Sara-Santini):** JunitTests, UML Sequence Diagram, Controller, Exceptions, Album, getImageAlbumURL, Statistics, StatisticService, Database

•	**[Francesco Voto](https://github.com/FrancescoVoto99):** Parsing, API_Instagram, Fotogafia, UML Use Case Diagram, Filter, FilterService, getURL, DataBase, GUI


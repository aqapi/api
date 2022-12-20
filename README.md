# api

Endpointy odpowiedzialne za udostępnienie danych o zanieczyszczeniu: 
- /data/ : dostępna lista wszystkich dostępnych danych z wszystkich stacji pogodowych w kraju
- /data/all : dane jakości powietrza bez identyfikatora
- /data/measuringData/{id} : dostępne dane z konkretnej stacji jakości powietrza poprzez podanie identyfikatora stacji

Endpointy odpowiedzialne za udostępnienie danych o stacjach jakości powietrza: 
- /station/ : udostępnienia listy stacji pomiarowych
- /station/all : udostępnienia liste stacji wraz z wszystkimi informacjami na temat stacji
- /station/{measuringStationId} : udostępnienia stacje pomiarowe według podanego identyfikatora
- /station/nearestStation : udostępnienia jakość powietrza z najbliższej stacji poprzez podanie lokalizacji geograficznej
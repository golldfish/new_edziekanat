# E-dziekanat

## Niezbędne narzędzia 
- Docker (dla szybkiego postawienia instancji bazy danych)
- Baza danych MySQL 
- Kompliator języka Java (Zalecany Intellij IDEA)


## Uruchamianie aplikacji 
1.  Wszystkie najważniejsze ustawienia znajdują się w pliku _application.yaml_. W razie konieczności proszę zmienić odpowiednie pola zgodnie z wymogami Państwa systemu:
    1.  Baza danych:
        1.  host: **192.168.1.43** ← Adres IP
        2.  table: **Test** ← Nazwa
        3.  username: **root** 
        4.  password: **mypass123**
    2.  port: **8585** ← Port na którym uruchomi się serwer tomcat i będzie możliwość dostępu do aplikacji 
2.  Bazą danych jest **MySQL**
3.  Należy skompilować aplikację poprzez uruchomienie jej pliku _main_ znajdującego się w _com.zut.edziekanat.project.ProjectApplication_ 
   lub poprzez zastosowanie komendy _gradlew clean build_ (Dla użytkowników systemu windows).
   
   W przypadku uruchomienia poprzez zastowowanie wyżej wymienionej komendy, plik wynikowy .jar powinien znajdować się w katalogu _build/libs_. Należy uruchomić go podstawową komendą uruchamiającą pliki Javy.

### Dodatkowe informacje
Do projektu został dołączony plik _Test.sql_ zawierający kompleksową bazę danych wraz z przykładowymi wartościami. 
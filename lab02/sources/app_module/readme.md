**Wykorzystując opcje maszyny wirtualnej możemy skonfigurować maszynę wirtualną pod kod stworzony przez nas.** <br>
Modyfikacja maszyny wirtualnej odbywa się poprzez:
1. Zmianę rozmiaru sterty
* Ustawianie początkowej i minimalnej wielkości sterty ("*-Xms*").
* Ustawianie maksymalnej wielkości stery ("*-Xmx*").
* Komentarz: Te wartości są używane dla sterty maszyny JVM, która rezerwuje pamięć dla serwera katalogów i jego pamięci podręcznej. Zwiększenie ilości dostępnej pamięci poprawi wydajność, ale zwiększenie jej do zbyt wysokiej wartości może mieć szkodliwy wpływ w postaci dłuższych przerw w pełnych przebiegach algorytmu odśmiecania. Ustawienie maksymalnej i minimalnej wielkości sterty poprzez wpisanie "*-Xms2G -Xmx2G*" spowoduje że minimalna i maksymalna wielkość sterty będzie taka sama i będzie wynosiła 2GB. Dzięki temu możemy uniknąć zmniejszania bieżącego rozmiaru sterty przez maszynę wirtualną po zwolnieniu wystarczającej ilości miejsca. Chcemy uniknąć tej operacji z tego powodu że zmniejsza ona wydajność
2. Zmianę ustawień algorytmu odśmiecania
* Ustawienie seryjnego algorytmu odśmiecania ("*-XX:-UseSerialGC*").
* Ustawienie algorytmu odśmiecania działającego równolegle ("*-XX:-UseParallelGC*").
* Ustawienie liczby wątków roboczych STW (stop-the-world) ("*-XX:ParallelGCThreads=n*").
* Ustawienie garbage collectora Garbage-First (G1)  ("*-XX:+UseG1GC*"). Celem G1 jest zapewnienie rozwiązania dla użytkowników uruchamiających aplikacje, które wymagają dużych stosów z ograniczonymi opóźnieniami GC. Oznacza to rozmiar sterty około 6 GB.
* Ustawienie rozmiaru regionu G1. Wartość będzie potęgą dwóch i może wynosić od 1 MB do 32 MB ("*-XX:G1HeapRegionSize=n*").
* Jedną z dostępnych opcji jest całkowite wyłączenie algorytmu odśmiecania ("*-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC*").

package CircularLL;

class NodeCSLL {
    Object data;
    NodeCSLL setelah;
}

public class CircularSingleLinkedList {
    private NodeCSLL pAwal, pAkhir;

    public CircularSingleLinkedList() {
        pAwal = null;
        pAkhir = null;
    }

    public void sisipDataDiAwal(Object data) {
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
        } else {
            pBaru.setelah = pAwal;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
        }
    }

    public void sisipDataDiAkhir(Object data) {
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
        } else {
            pBaru.setelah = pAwal;
            pAkhir.setelah = pBaru;
            pAkhir = pBaru;
        }
    }

    public void hapusData(Object dtHapus) {
        if (pAwal != null) {
            NodeCSLL pSbl = null;
            NodeCSLL pKini = pAwal;
            boolean ketemu = false;

            do {
                if (pKini.data.equals(dtHapus)) {
                    ketemu = true;
                } else {
                    pSbl = pKini;
                    pKini = pKini.setelah;
                }
            } while (!ketemu && (pKini != pAwal));

            if (ketemu) {
                if (pSbl == null) {
                    pAwal = pKini.setelah;
                    pAkhir.setelah = pAwal;
                } else {
                    if (pAkhir == pKini) {
                        pAkhir = pSbl;
                    }
                    pSbl.setelah = pKini.setelah;
                }
            }
        }
    }

    public void hapusSatuDataDiAwal() {
        if (pAwal != null) {
            if (pAwal == pAkhir) {
                pAwal = null;
                pAkhir = null;
            } else {
                pAwal = pAwal.setelah;
                pAkhir.setelah = pAwal;
            }
        }
    }

    public void hapusSatuDataDiAkhir() {
        if (pAwal != null) {
            if (pAwal == pAkhir) {
                pAwal = null;
                pAkhir = null;
            } else {
                NodeCSLL pKini = pAwal;
                while (pKini.setelah != pAkhir) {
                    pKini = pKini.setelah;
                }
                pAkhir = pKini;
                pAkhir.setelah = pAwal;
            }
        }
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        if (pAwal != null) {
            NodeCSLL pCetak = pAwal;
            do {
                System.out.print(pCetak.data + "->");
                pCetak = pCetak.setelah;
            } while (pCetak != pAwal);
            System.out.println();
        } else {
            System.out.println("List kosong.");
        }
    }

    public static void main(String[] args) {
        CircularSingleLinkedList csll = new CircularSingleLinkedList();

        csll.sisipDataDiAwal(50);
        csll.sisipDataDiAwal(60);
        csll.sisipDataDiAwal(70);
        csll.sisipDataDiAwal(8);
        csll.sisipDataDiAwal(90);
        csll.sisipDataDiAwal(19);

        csll.cetak("Data awal:");
        csll.hapusData(8);
        csll.cetak("8 dihapus:");
        csll.hapusData(90);
        csll.cetak("90 dihapus:");
        csll.sisipDataDiAkhir(100);
        csll.cetak("100 di akhir:");
        csll.hapusSatuDataDiAwal();
        csll.cetak("hapus awal:");
        csll.hapusSatuDataDiAkhir();
        csll.cetak("hapus akhir:");
    }
}

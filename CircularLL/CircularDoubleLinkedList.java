package CircularLL;

class NodeCDLL {
    Object data;
    NodeCDLL sebelum;
    NodeCDLL setelah;
}

public class CircularDoubleLinkedList {
    private NodeCDLL pAwal, pAkhir;

    public CircularDoubleLinkedList() {
        pAwal = null;
        pAkhir = null;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
        }
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAkhir.setelah = pBaru;
            pAkhir = pBaru;
        }
    }

    public void hapusData(Object dtHapus) {
        if (pAwal != null) {
            NodeCDLL pSbl = null, pKini = pAwal;
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
                    pAwal.sebelum = pAkhir;
                    pAkhir.setelah = pAwal;
                } else {
                    if (pAkhir == pKini) {
                        pAkhir = pSbl;
                    }
                    pSbl.setelah = pKini.setelah;
                    pKini.setelah.sebelum = pSbl;
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
                pAwal.sebelum = pAkhir;
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
                pAkhir = pAkhir.sebelum;
                pAkhir.setelah = pAwal;
                pAwal.sebelum = pAkhir;
            }
        }
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        if (pAwal != null) {
            NodeCDLL pCetak = pAwal;
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
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();

        cdll.SisipDataDiAwal(new Integer(50));
        cdll.SisipDataDiAwal(new Integer(60));
        cdll.SisipDataDiAwal(new Integer(70));
        cdll.SisipDataDiAwal(new Integer(8));
        cdll.SisipDataDiAwal(new Integer(9));
        cdll.SisipDataDiAwal(new Integer(90));
        cdll.SisipDataDiAwal(new Integer(19));

        cdll.cetak("Data Awal");
        cdll.SisipDataDiAkhir(new Integer(100));
        cdll.cetak("100 di akhir");
        cdll.hapusData(70);
        cdll.cetak("70 dihapus");
        cdll.hapusSatuDataDiAwal();
        cdll.cetak("hapus awal");
        cdll.hapusSatuDataDiAkhir();
        cdll.cetak("hapus akhir");
    }
}
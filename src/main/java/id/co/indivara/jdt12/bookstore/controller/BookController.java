package id.co.indivara.jdt12.bookstore.controller;

import id.co.indivara.jdt12.bookstore.entity.Book;
import id.co.indivara.jdt12.bookstore.entity.BukuMahal;
import id.co.indivara.jdt12.bookstore.entity.BukuMurah;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class BookController {

    @GetMapping("/Buku")
    public Book salamGetBook(
            @RequestParam(value = "code", defaultValue = "1") String isbn,
            @RequestParam(value = "nama", defaultValue = "JejakSiDul") String judul,
            @RequestParam(value = "pengarang", defaultValue = "DUl") String pengarang) {
        return new Book(isbn,"" + judul, "" +pengarang+""+",GET");
    }

    @GetMapping("/Buku/{isbn}/{judul}/{pengarang}")
    public Book tampilkanMenu(
            @PathVariable("isbn")String isbn,
            @PathVariable("judul")String judul,
            @PathVariable("pengarang")String pengaran){
        return new Book(isbn,judul,pengaran);
    }

//    @PostMapping("/simpan")
//    public Book simpanBuku(
//            @RequestBody Book jsonData){
//        Book book=jsonData;
//        book.setPengarang(book.getPengarang()+" INI DARI JSON BRO");
//        return book;
//    }



    @PostMapping("/Buku")
    public Book salamPostBook(
            @RequestParam(value = "code", defaultValue = "2") String isbn,
            @RequestParam(value = "nama", defaultValue = "JejakSiDul") String judul,
            @RequestParam(value = "pengarang", defaultValue = "DUl") String pengarang) {
        return new Book(isbn, "" + judul, "" + pengarang +""+ "POST");
    }

    @PatchMapping("/Buku")
    public Book salamPatchBook(
            @RequestParam(value = "code", defaultValue = "3") String isbn,
            @RequestParam(value = "nama", defaultValue = "JejakSiDul") String judul,
            @RequestParam(value = "pengarang", defaultValue = "DUl") String pengarang) {
        return new Book(isbn, "" + judul,  "" + pengarang +""+ "PATCH");
    }

    @DeleteMapping("/Buku")
    public Book salamBook(
            @RequestParam(value = "code", defaultValue = "1") String isbn,
            @RequestParam(value = "nama", defaultValue = "JejakSiDul") String judul,
            @RequestParam(value = "pengarang", defaultValue = "DUl") String pengarang) {
        return new Book(isbn,"" + judul , "" + pengarang +""+ "DELETE");
    }

    @PostMapping("/simpan")
    public BukuMahal simpannBuku(
            @RequestBody Book jsonData){
            Book b=jsonData;
            BukuMahal bm=new BukuMahal();
            bm.setIsbn(b.getIsbn());
            bm.setJudul(b.getJudul());
            bm.setPengarang(b.getPengarang());
            bm.setCover("Besi");
            bm.setKemasan("Kotak Kayu");
            return bm;
    }
    @GetMapping("/all")
    public ArrayList<Book>findAllBook(){
        ArrayList<Book> list=new ArrayList<Book>();
        list.add (new Book("1111","Cara ini","Agus"));
        list.add( new Book("222","Cara itu","Budi"));
        list.add(new Book("333","Cara lain","Charlie"));
        return list;
    }

    @PostMapping("/termurah")
    public BukuMurah findBukuTermurah(@RequestBody ArrayList<BukuMurah>list){
        BukuMurah buku= list.get(1);
        for(BukuMurah b:list){
            if(b.getHarga()< buku.getHarga()){
                buku=b;
            }
        }
        return buku;
    }
}


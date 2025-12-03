package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Barang;
import com.example.demo.entity.Kurir;
import com.example.demo.entity.Pelanggan;
import com.example.demo.entity.Pengiriman;
import com.example.demo.entity.Transaksi;
import com.example.demo.service.BarangService;
import com.example.demo.service.KurirService;
import com.example.demo.service.PelangganService;
import com.example.demo.service.PengirimanService;
import com.example.demo.service.TransaksiService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class EkspedisiController {
    @Autowired
    private PelangganService pelangganService;
    @Autowired
    private BarangService barangService;
    @Autowired
    private PengirimanService pengirimanService;
    @Autowired
    private KurirService kurirService;
    @Autowired
    private TransaksiService transaksiService;

    // MENU

    @GetMapping(value="/login")
    public String menuLoginPage(Model model, HttpServletRequest request) {
    if(request.getSession().getAttribute("Pengiriman") != null){
        return "redirect:/menu";
    }
        else return "loginmenu";
    }

    @PostMapping(value="/validateLoginMenu")
    public String menuLogin(Model model, @RequestParam(value="PesananID") Integer kodeUser,
    @RequestParam(value="noPemesanan") String passUser, HttpServletRequest request) {
        Pengiriman P = pengirimanService.findPengiriman(kodeUser);
        model.addAttribute("userRec", P);
            if(P != null && passUser.equals(P.getNoPemesanan())) {
            request.getSession().setAttribute("Pengiriman", P);
            model.addAttribute("userRec", P);
            return "redirect:/menu";
        }
        else return "redirect:/login";
    }

    @GetMapping(value="/logoutMenu")
    public String menulogout(HttpServletRequest request) {
    if (request.getSession().getAttribute("Pengiriman") != null) {
        request.getSession().invalidate();
    }
        return "redirect:/login";
    }

    @GetMapping(value={"/menu", "/menu/"})
    public String MenuPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Pengiriman") != null){
            model.addAttribute("logMenu", request.getSession().getAttribute("Pengiriman"));
            return "menu";
        } else {
            return "redirect:/login";
        }
    }

    // Pelanggan

    @GetMapping(value={"/pelanggan", "/pelanggan/"})
    public String PelangganPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Pengiriman") != null){
            List<Pelanggan> pelangganList = pelangganService.getAllPelanggan();
            model.addAttribute("pelangganList", pelangganList);
            model.addAttribute("pelangganInfo", new Pelanggan());
            return "pelanggan.html";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/pelanggan/{id}")
    public String pelangganGetRec(Model model, @PathVariable("id") Integer id){
        List<Pelanggan> pelangganList = pelangganService.getAllPelanggan();
        Pelanggan pelangganRec = pelangganService.getPelangganById(id);
        model.addAttribute("pelangganList", pelangganList);
        model.addAttribute("pelangganRec", pelangganRec);
        return "pelanggan";
    }

    @PostMapping( value={"/pelanggan/submit/", "/pelanggan/submit/{id}"}, params={"add"})
    public String pelangganAdd(@ModelAttribute("pelangganInfo") Pelanggan pelangganInfo){
        pelangganService.addPelanggan(pelangganInfo);
        return "redirect:/pelanggan";
    }

    @PostMapping( value="/pelanggan/submit/{id}", params={"edit"})
    public String pelangganEdit(@ModelAttribute("pelangganInfo") Pelanggan pelangganInfo,
    @PathVariable("id") Integer id){
        pelangganService.updatePelanggan(id, pelangganInfo);
        return "redirect:/pelanggan";
    }

    @PostMapping( value="/pelanggan/submit/{id}", params={"delete"})
    public String pelangganDelete(@PathVariable("id") Integer id){
        pelangganService.deletePelanggan(id);
        return "redirect:/pelanggan";
    }




    // Kurir

    @GetMapping(value = {"/kurir", "/kurir/"})
    public String kurirPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Pengiriman") != null){
        List<Kurir> kurirList = kurirService.getAllKurir();
        model.addAttribute("kurirList", kurirList);
        model.addAttribute("kurirInfo", new Kurir());
        return "kurir";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/kurir/{id}")
    public String kurirGetRec(Model model, @PathVariable("id") Integer id, HttpServletRequest request) {
        List<Kurir> kurirList = kurirService.getAllKurir();
        Kurir kurirRec = kurirService.getKurirById(id);

        model.addAttribute("kurirList", kurirList);
        model.addAttribute("kurirRec", kurirRec);
        model.addAttribute("kurirInfo", new Kurir());
        return "kurir";
    }

    @PostMapping( value={"/kurir/submit/", "/kurir/submit/{id}"}, params={"add"})
    public String kurirAdd(@ModelAttribute("kurirInfo") Kurir kurirInfo){
        kurirService.addKurir(kurirInfo);
        return "redirect:/kurir";
    }

    @PostMapping( value="/kurir/submit/{id}", params={"edit"})
    public String kurirEdit(@ModelAttribute("kurirInfo") Kurir kurirInfo,
    @PathVariable("id") String id){
        kurirService.updateKurir(id, kurirInfo);
        return "redirect:/kurir";
    }

    @PostMapping( value="/kurir/submit/{id}", params={"delete"})
    public String kurirDelete(@PathVariable("id") Integer id){
        kurirService.deleteKurir(id);
        return "redirect:/kurir";
    }


    // BARANG

    @GetMapping(value = {"/barang", "/barang/"})
    public String barangPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Pengiriman") != null){
            List<Barang> barangList = barangService.getAllBarang();
            model.addAttribute("barangList", barangList);
            model.addAttribute("barangInfo", new Barang());
            return "barang";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/barang/{id}")
    public String barangGetRec(Model model, @PathVariable("id") Integer id, HttpServletRequest request) {
        List<Barang> barangList = barangService.getAllBarang();
        Barang barangRec = barangService.getBarangById(id);

        model.addAttribute("barangList", barangList);
        model.addAttribute("barangRec", barangRec);
        model.addAttribute("barangInfo", new Barang());
        return "barang";
    }

    @PostMapping( value={"/barang/submit/", "/barang/submit/{id}"}, params={"add"})
    public String barangAdd(@ModelAttribute("barangInfo") Barang barangInfo){
        barangService.addBarang(barangInfo);
        return "redirect:/barang";
    }

    @PostMapping( value="/barang/submit/{id}", params={"edit"})
    public String barangEdit(@ModelAttribute("barangInfo") Barang barangInfo,
    @PathVariable("id") Integer id){
        barangService.updateBarang(id, barangInfo);
        return "redirect:/barang";
    }

    @PostMapping( value="/barang/submit/{id}", params={"delete"})
    public String barangDelete(@PathVariable("id") Integer id){
        barangService.deleteBarang(id);
        return "redirect:/barang";
    }

    // Pengiriman

    @GetMapping(value = {"/pengiriman", "/pengiriman/"})
    public String pengirimanPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Pengiriman") != null){
            List<Pengiriman> pengirimanList = pengirimanService.getAllPengiriman();
            model.addAttribute("pengirimanList", pengirimanList);
            model.addAttribute("pengirimanInfo", new Pengiriman());
            return "pengiriman";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/pengiriman/{id}")
    public String pengirimanGetRec(Model model, @PathVariable("id") Integer id, HttpServletRequest request) {
        List<Pengiriman> pengirimanList = pengirimanService.getAllPengiriman();
        Pengiriman pengirimanRec = pengirimanService.getPengirimanById(id);

        model.addAttribute("pengirimanList", pengirimanList);
        model.addAttribute("pengirimanRec", pengirimanRec);
        model.addAttribute("pengirimanInfo", new Pengiriman());
        return "pengiriman";
    }

    @PostMapping( value={"/pengiriman/submit/", "/pengiriman/submit/{id}"}, params={"add"})
    public String pengirimanAdd(@ModelAttribute("pengirimanInfo") Pengiriman pengirimanInfo){
        pengirimanService.addPengiriman(pengirimanInfo);
        return "redirect:/pengiriman";
    }

    @PostMapping( value="/pengiriman/submit/{id}", params={"edit"})
    public String pengirimanEdit(@ModelAttribute("pengirimanInfo") Pengiriman pengirimanInfo,
    @PathVariable("id") Integer id){
        pengirimanService.updatePengiriman(id, pengirimanInfo);
        return "redirect:/pengiriman";
    }

    @PostMapping( value="/pengiriman/submit/{id}", params={"delete"})
    public String pengirimanDelete(@PathVariable("id") Integer id){
        pengirimanService.deletePengiriman(id);
        return "redirect:/pengiriman";
    }

    // Transaksi

    @GetMapping(value = {"/transaksi", "/transaksi/"})
    public String transaksiPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Pengiriman") != null){
            List<Transaksi> transaksiList = transaksiService.getAllTransaksi();
            model.addAttribute("transaksiList", transaksiList);
            model.addAttribute("transaksiInfo", new Transaksi());
            
            List<Pelanggan> pelangganList = pelangganService.getAllPelanggan();
            List<Barang> barangList = barangService.getAllBarang();
            List<Pengiriman> pengirimanList = pengirimanService.getAllPengiriman();

            model.addAttribute("pelangganList", pelangganList);
            model.addAttribute("barangList", barangList);
            model.addAttribute("pengirimanList", pengirimanList);
            return "transaksi";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/transaksi/{id}")
    public String transaksiGetRec(Model model, @PathVariable("id") Integer id, HttpServletRequest request) {

        List<Transaksi> transaksiList = transaksiService.getAllTransaksi();
        Transaksi transaksiRec = transaksiService.getTransaksiById(id);

        List<Pelanggan> pelangganList = pelangganService.getAllPelanggan();
        List<Pengiriman> pengirimanList = pengirimanService.getAllPengiriman();
            
        model.addAttribute("pelangganList", pelangganList);
        model.addAttribute("pengirimanList", pengirimanList);
        model.addAttribute("transaksiList", transaksiList);
        model.addAttribute("transaksiRec", transaksiRec);
        model.addAttribute("transaksiInfo", new Transaksi());
        return "transaksi";
    }

    @PostMapping( value={"/transaksi/submit/", "/transaksi/submit/{id}"}, params={"add"})
    public String transaksiAdd(@ModelAttribute("transaksiInfo") Transaksi transaksiInfo){
        transaksiService.addTransaksi(transaksiInfo);
        return "redirect:/transaksi";
    }

    @PostMapping( value="/transaksi/submit/{id}", params={"edit"})
    public String transaksiEdit(@ModelAttribute("transaksiInfo") Transaksi transaksiInfo,
    @PathVariable("id") Integer id){
        transaksiService.updateTransaksi(id, transaksiInfo);
        return "redirect:/transaksi";
    }

    @PostMapping( value="/transaksi/submit/{id}", params={"delete"})
    public String transaksiDelete(@PathVariable("id") Integer id){
        transaksiService.deleteTransaksi(id);
        return "redirect:/transaksi";
    }

}
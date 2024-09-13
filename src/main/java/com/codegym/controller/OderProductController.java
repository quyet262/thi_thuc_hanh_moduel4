package com.codegym.controller;

import com.codegym.model.OderProduct;
import com.codegym.service.oder_product.OderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/oders")
public class OderProductController {
    @Autowired
    private OderProductService orderProductService;

    @GetMapping("")
    public ModelAndView index(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size,
                              @RequestParam(required = false) LocalDate starDate,
                              @RequestParam(required = false) LocalDate endDate) {
        Page<OderProduct> oderProducts;
        Pageable pageable = PageRequest.of(page, size);
        if (starDate == null || endDate == null) {
            oderProducts = orderProductService.findAll(pageable);
        } else {
            oderProducts = orderProductService.findOderProductByDate(starDate, endDate, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/oders/index");
        modelAndView.addObject("oderProducts", oderProducts);
        return modelAndView;
    }


    @GetMapping("/{id}/edit")
    public ModelAndView updateOderProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/oders/update");
        Optional<OderProduct> oderProduct = orderProductService.findById(id);
        modelAndView.addObject("oderProduct", oderProduct.get());
        return modelAndView;
    }


    @PostMapping("/update")
    public String updateOderProduct(OderProduct oderProduct) {
        orderProductService.save(oderProduct);
        return "redirect:/oders";
    }
}

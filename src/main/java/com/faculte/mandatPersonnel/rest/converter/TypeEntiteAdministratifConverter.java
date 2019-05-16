/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.TypeEntiteAdministratif;
import com.faculte.mandatPersonnel.rest.vo.TypeEntiteAdministratifVo;

/**
 *
 * @author abdou
 */
public class TypeEntiteAdministratifConverter extends AbstractConverter<TypeEntiteAdministratif,TypeEntiteAdministratifVo >{

    @Override
    public TypeEntiteAdministratif toItem(TypeEntiteAdministratifVo vo) {
         if (vo == null) {
            return null;
        } else {
            TypeEntiteAdministratif item = new TypeEntiteAdministratif();
            item.setId(vo.getId());
            item.setLibelle(vo.getLibelle());
            return item;
        }
    }

    @Override
    public TypeEntiteAdministratifVo toVo(TypeEntiteAdministratif item) {
           if(item==null){
            return null;
        }
        else{
            TypeEntiteAdministratifVo vo =new TypeEntiteAdministratifVo();
            vo.setId(item.getId());
            vo.setLibelle(item.getLibelle());
            return vo;
        }
    }
    }
    


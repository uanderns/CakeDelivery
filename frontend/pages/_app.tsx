import '../public/css/global.css'
import React, { useState } from 'react';
import { MyGlobalContext } from '../public/components/context/GlobalContext';
import { Alerts } from '../public/components/alerts/alerts';
import { ModalNovoProduto, ModalNovoTipo, ModalNovoSabor, ModalNovoTamanho, ModalEsqueciSenha } from '../public/components/modal/Modal';

export default function App({ Component, pageProps }) {

   const [totalPrice, setTotalPrice] = useState(0);
   const [produtos, setProdutos] = useState(0);
   const [alertMsg, setAlertMsg] = useState("");
   const [isVisible, setIsVisible] = useState(false);
   const [produtoSelected, setProdutoSelected] = useState(false);
   const [typeAlert, setTypeAlert] = useState('default');
   const [showModalProduto, setShowModalProduto] = useState(false);
   const [showModalSabor, setShowModalSabor] = useState(false);
   const [showModalTipo, setShowModalTipo] = useState(false);
   const [showModalTamanho, setShowModalTamanho] = useState(false);
   const [showModalEsqueciSenha, setShowModalEsqueciSenha] = useState(false);

   return (
      <MyGlobalContext.Provider value={
         {
            totalPrice, setTotalPrice,
            produtos, setProdutos,
            alertMsg, setAlertMsg,
            typeAlert, setTypeAlert,
            isVisible, setIsVisible,
            produtoSelected, setProdutoSelected,
            showModalProduto, setShowModalProduto,
            showModalSabor, setShowModalSabor,
            showModalTipo, setShowModalTipo,
            showModalTamanho, setShowModalTamanho,
            showModalEsqueciSenha, setShowModalEsqueciSenha
         }
      }>
         <Alerts />
         <ModalNovoProduto />
         <ModalNovoTipo />
         <ModalNovoSabor />
         <ModalNovoTamanho />
         <ModalEsqueciSenha />
         <Component {...pageProps} />
      </MyGlobalContext.Provider>
   )
}
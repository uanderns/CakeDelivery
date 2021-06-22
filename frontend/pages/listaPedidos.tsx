import { Header, Footer } from '../public/components';
import React, { useState, useEffect } from 'react';
import style from '../public/css/listaPedidos.module.scss';
import { CardProdutoAdm } from '../public/components';
import axios from 'axios';

const ListaPedidos = () => {
    const [menu, setMenu] = useState([]);

    useEffect(() => {
        const getAllProdutos = () => {
            axios.get('https://webapimydelivery.com.br/Cardapio')
                .then(response => {
                    setMenu(response.data);
                }).catch(err => { console.log(err) })
        }

        getAllProdutos();
    }, []);

    const limitDesc = (descricao) => {
        if (descricao.length > 170) {
            return descricao.substring(0, 170) + "...";
        }
        return descricao;
    }

    return (
        <>
            <Header />
                <div className={style.body}>
                    <div className={style.container}>
                        <section className={style.sectionProduto}>
                            <div className={style.sideLeft}>
                                {
                                    menu.length &&
                                    menu.map((item) => {
                                        return (
                                            <CardProdutoAdm name={item.TITULO} price={item.PRECO} description={limitDesc(item.DESCRICAO)} produtoID={item.id} key={item.id} />
                                        )
                                    })
                                }
                            </div>
                            <div className={style.sideRight}>
                                <div className={style.resumoPedido}>
                                    <h1>Resumo Pedido</h1>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            <Footer />
        </>
    )
}

export default ListaPedidos;
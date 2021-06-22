import React, { useState, useEffect } from 'react';
import style from './cardapio.module.scss';
import { CardProduto, Maps, CloseOrder, Filter, Address, Alerts } from '..';
import axios from 'axios';

export function Cardapio() {

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
        <div className={style.body}>
            <div className={style.container}>
                <section className={style.sectionFilter}>
                    <Filter />
                </section>
                <section className={style.sectionProduto}>
                    {
                        menu.length &&
                        menu.map((item) => {
                            return (
                                <CardProduto name={item.TITULO} image={`../../images/${item.IMAGEM}`} price={item.PRECO} description={limitDesc(item.DESCRICAO)} produtoID={item.id} key={item.id} />
                            )
                        })
                    }
                </section>
                <section className={style.sectionAddress}>
                    <Address />
                </section>
                <section className={style.sectionMaps}>
                    <Maps />
                </section>
                <section className={style.sectionCloseOrder}>
                    <CloseOrder />
                </section>
            </div>
        </div>
    )
}
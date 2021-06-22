import React, { useState, useContext } from 'react';
import style from './cardProduto.module.scss';
import ICardProduto from './../../interface/ICardProduto';
import { MyGlobalContext } from '../context/GlobalContext';

export function CardProduto({ name, image, price, description, ...props }: ICardProduto) {

    const [IsSelected, setIsSelected] = useState(false);
    const { totalPrice, setTotalPrice, produtos, setProdutos } = useContext(MyGlobalContext);

    const changeCheck = () => {
        setIsSelected(!IsSelected);
        if (!IsSelected) {
            setProdutos(produtos + 1);
            setTotalPrice(totalPrice + price);
        } else {
            setProdutos(produtos - 1);
            setTotalPrice(totalPrice - price);
        }
    }

    return (
        <div className={`${style.cardProduto} ${IsSelected ? style.selected : ''}`} onClick={() => changeCheck()}>
            <div className={style.name}>
                <span>{name}</span>
            </div>
            {
                image &&
                <div className={style.image}>
                    <img src={image} />
                </div>
            }
            <div className={style.price}>
                <span>R$ {price}</span>
            </div>
            <hr className={style.divisor} />
            <div className={style.description}>
                <p>
                    {description}
                </p>
            </div>
        </div>
    )
}

export function CardProdutoAdm({ name, image, price, description, produtoID, ...props }: ICardProduto) {

    const { produtoSelected, setProdutoSelected } = useContext(MyGlobalContext);
    const [IsSelected, setIsSelected] = useState(false);

    const showInfo = () => {
        console.log('aqui')
        if(produtoSelected && IsSelected){
            setIsSelected(true);
            setProdutoSelected(false);
        }else{
            setIsSelected(false);
            setProdutoSelected(false);
            setIsSelected(true);
            setProdutoSelected(true);
        }
    }

    return (
        <div className={`${style.cardProdutoAdm} ${produtoSelected && IsSelected ? style.selected : ''}`} onClick={() => showInfo()}>
            <div className={style.name}>
                <span>{name}</span>
            </div>
            {
                image &&
                <div className={style.image}>
                    <img src={image} />
                </div>
            }
            <div className={style.price}>
                <span>R$ {price}</span>
            </div>
            <hr className={style.divisor} />
            <div className={style.description}>
                <p>
                    {description}
                </p>
            </div>
        </div>
    )
}
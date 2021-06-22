import style from './modal.module.scss';
import { Input } from '../input/Input';
import { useContext, useEffect, useState } from 'react';
import { MyGlobalContext } from '../context/GlobalContext';

export function ModalNovoProduto() {

    const { showModalProduto, setShowModalProduto, setIsVisible, setTypeAlert, setAlertMsg } = useContext(MyGlobalContext);

    const clickEvent = (e, typeAlert) => {
        e.preventDefault();
        setIsVisible(true);
        setTypeAlert(typeAlert);
        setAlertMsg('Salvo com sucesso');
    }

    const closeModal = () => {
        setShowModalProduto(false);
    }

    return (
        <>
            {
                showModalProduto &&
                <div className={style.modalNovoProduto} >
                    <div className={style.header}>
                        <div className={style.title}>
                            <span>NOVO BOLO</span>
                        </div>
                        <div className={style.close}>
                            <img src="/images/close.svg" alt="Fechar Modal" onClick={() => closeModal()} />
                        </div>
                    </div>
                    <div className={style.content}>
                        <Input type={"text"} placeholder={"Nome do bolo"} size={'x100'} />
                        <Input type={"number"} placeholder={"Preço"} size={'x100'} />
                        <Input type={"text"} placeholder={"Link da Imagem do bolo"} size={'x100'} />
                        <Input type={"text"} placeholder={"Informe o sabor do bolo"} size={'x100'} />
                        <Input type={"text"} placeholder={"Informe a descrição"} size={'x100'} />
                        <Input type={"text"} placeholder={"Informe o tipo do bolo"} size={'x100'} />
                        <Input type={"text"} placeholder={"Informe o tamanho do bolo"} size={'x100'} />

                    </div>
                    <div className={style.actions}>
                        <div className={style.btnSalvar} onClick={(e) => clickEvent(e, 'success')}>
                            <span>Salvar</span>
                        </div>
                    </div>
                </div>
            }
        </>
    )
}

export function ModalNovoSabor() {

    const { showModalSabor, setShowModalSabor, setIsVisible, setTypeAlert, setAlertMsg } = useContext(MyGlobalContext);

    const clickEvent = (e, typeAlert) => {
        e.preventDefault();
        setIsVisible(true);
        setTypeAlert(typeAlert);
        setAlertMsg('Salvo com sucesso');
    }

    const closeModal = () => {
        setShowModalSabor(false);
    }

    return (
        <>
            {
                showModalSabor &&
                <div className={style.modalNovoProduto} >
                    <div className={style.header}>
                        <div className={style.title}>
                            <span>NOVO SABOR</span>
                        </div>
                        <div className={style.close}>
                            <img src="/images/close.svg" alt="Fechar Modal" onClick={() => closeModal()} />
                        </div>
                    </div>
                    <div className={style.content}>
                        <Input type={"text"} placeholder={"Nome do sabor"} size={'x100'} />
                        <Input type={"text"} placeholder={"Descrição"} size={'x100'} />
                        
                    </div>
                    <div className={style.actions}>
                        <div className={style.btnSalvar} onClick={(e) => clickEvent(e, 'success')}>
                            <span>Salvar</span>
                        </div>
                    </div>
                </div>
            }
        </>
    )
}

export function ModalNovoTipo() {

    const { showModalTipo, setShowModalTipo, setIsVisible, setTypeAlert, setAlertMsg } = useContext(MyGlobalContext);

    const clickEvent = (e, typeAlert) => {
        e.preventDefault();
        setIsVisible(true);
        setTypeAlert(typeAlert);
        setAlertMsg('Salvo com sucesso');
    }

    const closeModal = () => {
        setShowModalTipo(false);
    }

    return (
        <>
            {
                showModalTipo &&
                <div className={style.modalNovoProduto} >
                    <div className={style.header}>
                        <div className={style.title}>
                            <span>NOVO TIPO</span>
                        </div>
                        <div className={style.close}>
                            <img src="/images/close.svg" alt="Fechar Modal" onClick={() => closeModal()} />
                        </div>
                    </div>
                    <div className={style.content}>
                        <Input type={"text"} placeholder={"Informe o nome do tipo"} size={'x100'} />
                       
                    </div>
                    <div className={style.actions}>
                        <div className={style.btnSalvar} onClick={(e) => clickEvent(e, 'success')}>
                            <span>Salvar</span>
                        </div>
                    </div>
                </div>
            }
        </>
    )
}

export function ModalNovoTamanho() {

    const { showModalTamanho, setShowModalTamanho, setIsVisible, setTypeAlert, setAlertMsg } = useContext(MyGlobalContext);

    const clickEvent = (e, typeAlert) => {
        e.preventDefault();
        setIsVisible(true);
        setTypeAlert(typeAlert);
        setAlertMsg('Salvo com sucesso');
    }

    const closeModal = () => {
        setShowModalTamanho(false);
    }

    return (
        <>
            {
                showModalTamanho &&
                <div className={style.modalNovoProduto} >
                    <div className={style.header}>
                        <div className={style.title}>
                            <span>NOVO TAMANHO</span>
                        </div>
                        <div className={style.close}>
                            <img src="/images/close.svg" alt="Fechar Modal" onClick={() => closeModal()} />
                        </div>
                    </div>
                    <div className={style.content}>
                        <Input type={"number"} placeholder={"Informe o tamanho"} size={'x100'} />
                        
                    </div>
                    <div className={style.actions}>
                        <div className={style.btnSalvar} onClick={(e) => clickEvent(e, 'success')}>
                            <span>Salvar</span>
                        </div>
                    </div>
                </div>
            }
        </>
    )
}

export function ModalEsqueciSenha() {

    const { showModalEsqueciSenha, setShowModalEsqueciSenha, setIsVisible, setTypeAlert, setAlertMsg } = useContext(MyGlobalContext);

    const clickEvent = (e, typeAlert) => {
        e.preventDefault();
        setIsVisible(true);
        setTypeAlert(typeAlert);
        setAlertMsg('Email enviado com sucesso');
    }

    const closeModal = () => {
        setShowModalEsqueciSenha(false);
    }

    return (
        <>
            {
                showModalEsqueciSenha &&
                <div className={style.modalEsqueciMinhaSenha} >
                    <div className={style.header}>
                        <div className={style.title}>
                            <span>ESQUECI MINHA SENHA</span>
                        </div>
                        <div className={style.close}>
                            <img src="/images/close.svg" alt="Fechar Modal" onClick={() => closeModal()} />
                        </div>
                    </div>
                    <div className={style.content}>
                        <Input type={"text"} placeholder={"Insira seu e-mail"} size={'x100'} />
                    </div>
                    <div className={style.actions}>
                        <div className={style.btnEnviar} onClick={(e) => clickEvent(e, 'success')}>
                            <span>Enviar</span>
                        </div>
                    </div>
                </div>
            }
        </>
    )
}
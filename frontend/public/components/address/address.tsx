import { useState, useEffect, useContext } from 'react';
import style from './address.module.scss';
import axios from 'axios';
import { MyGlobalContext } from '../context/GlobalContext';

export function Address() {

    const [cep, setCep] = useState("");
    const [numero, setNumero] = useState("");
    const [complemento, setComplemento] = useState("");
    const [referencia, setReferencia] = useState("");
    const [logradouro, setLogradouro] = useState("");
    const [bairro, setBairro] = useState("");
    const [cidade, setCidade] = useState("");
    const [estado, setEstado] = useState("");
    const [hasCep, setHasCep] = useState(false);

    const { setAlertMsg, setIsVisible } = useContext(MyGlobalContext);

    useEffect(() => {
        const completeAddress = () => {

            axios.get(`https://viacep.com.br/ws/${cep}/json/`)
                .then(response => {
                    console.log(response);
                    if (response.status == 200) {
                        setLogradouro(response.data.logradouro);
                        setBairro(response.data.bairro);
                        setCidade(response.data.localidade);
                        setEstado(response.data.uf);
                        setHasCep(true);
                    } else {
                        setLogradouro("");
                        setBairro("");
                        setCidade("");
                        setEstado("");
                        setHasCep(false);
                    }
                }).catch(error => {
                    setHasCep(false);
                    setAlertMsg("CEP não encontrado!");
                    setIsVisible(true);
                })
        };

        if (cep.length) {
            completeAddress();
        }

    }, [cep]);


    return (
        <div className={style.address}>
            <div className={style.wrap}>
                <select>
                    <option>
                        Tipo de endereço
                    </option>
                    <option>
                        Apartamento
                    </option>
                    <option>
                        Casa
                    </option>
                    <option>
                        Comercial
                    </option>
                    <option>
                        Outro
                    </option>
                </select>
                <input type={'text'} placeholder={'CEP'} onBlur={(e) => setCep(e.target.value)} />
                <input type={'text'} placeholder={'Número'} />
            </div>
            {
                hasCep &&
                <>
                    <div className={style.wrap}>
                        <input type={'text'} placeholder={'Complemento'} />
                        <input type={'text'} placeholder={'Informações de referência'} />
                        <input type={'text'} placeholder={'Logradouro'} defaultValue={logradouro} />
                    </div>
                    <div className={style.wrap}>
                        <input type={'text'} placeholder={'Bairro'} defaultValue={bairro} />
                        <input type={'text'} placeholder={'Cidade'} defaultValue={cidade} />
                        <input type={'text'} placeholder={'Estado'} defaultValue={estado} />
                    </div>

                </>
            }
        </div>
    )
}
import style from './wizard.module.scss';

export function Wizard(){
    return(
        <div className={style.wizard}>
            <div className={style.container}>
                <div className={style.instructions}>
                    <span>SIGA AS<br/>ETAPAS</span>
                </div>
                <div className={style.steps}>
                    <ul>
                        <li><a>1</a> Selecione os produtos e localização.</li>
                        <li><a>2</a> Depois clique em "<strong>ENVIAR PEDIDO"</strong></li>
                    </ul>
                </div>
            </div>
        </div>
    )
}
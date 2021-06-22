import { Header, Cardapio, Footer, Wizard } from '../public/components';
import { ModalNovoProduto } from '../public/components/modal/Modal';

const listaProdutos = () => {
    return (
        <>
            <Header />
            <Wizard />
            <Cardapio />
            <Footer />
        </>
    )
}

export default listaProdutos;
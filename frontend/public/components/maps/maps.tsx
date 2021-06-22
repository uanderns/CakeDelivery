import style from './maps.module.scss'

export function Maps() {
    return (
        <div className={style.maps}>
            <iframe src="https://embed.waze.com/iframe?zoom=12&lat=-22.9035&lon=-43.2096"width="100%" height="450"></iframe>
            {/* <iframe src="https://www.google.com/maps/embed?pb=!1m23!1m12!1m3!1d58867.64752465483!2d-42.899336117220386!3d-22.756919532223666!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m8!3e2!4m5!1s0x99bff5afbc21c3%3A0x81cefcbdcd8acf65!2zSXRhYm9yYcOtLCBSSg!3m2!1d-22.7570025!2d-42.864316699999996!4m0!5e0!3m2!1spt-BR!2sbr!4v1617805263750!5m2!1spt-BR!2sbr" width="100%" height="450" loading="lazy"></iframe> */}
        </div>
    )
}
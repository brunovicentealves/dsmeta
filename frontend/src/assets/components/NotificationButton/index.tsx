import icon from '../../img/notification-icon.svg'
import '../NotificationButton/styles.css'

function NotificationButton() {
    return (
        <div className="dsmeta-red-btn">
            <img src={icon} alt="Notificar" />
        </div>

    )
}

export default NotificationButton
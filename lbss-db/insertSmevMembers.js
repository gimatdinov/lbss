db.SmevMember.insert({
    _id: 10,
    "CertificateHash": "e57e05f212f2c72aa0ca648f16eb1e88",
    "FtpUserPassword": "FSVP",
    "HumanReadableName": "Россельхознадзор",
    "Mnemonic": "FSVP",
    "MpcRegistrationList": [
        {
            "namespace": "http://sample.otr.com/RSKHNDebtorInfo/3.0.3",
            "rootElement": "rskhnDebtorInfoAppDataRequest"
        },
        {
            "namespace": "http://sample.otr.com/RSKHNDebtorInfo/3.0.3",
            "rootElement": "rskhnDebtorInfoAppDataResponse"
        },
        {
            "namespace": "http://sample.otr.com/RSHNEPGU/LicensingPharmaceuticalActivities/3.0.0",
            "rootElement": "RequestData"
        },
        {
            "namespace": "http://sample.otr.com/RSHNEPGU/LicensingPharmaceuticalActivities/3.0.0",
            "rootElement": "ResponseData"
        }
    ],
    "Type": "OIV"
});
db.SmevMember.insert({
    _id: 11,
    "CertificateHash": "45743c93cd60544c12c78e264c7bf264",
    "FtpUserPassword": "EPGU",
    "HumanReadableName": "ЕПГУ",
    "Mnemonic": "EPGU",
    "MpcRegistrationList": [
        {
            "namespace": "http://epgu.gosuslugi.ru/lk/order/event/PROD/3.1.0",
            "rootElement": "eventServiceRequest"
        },
        {
            "namespace": "http://epgu.gosuslugi.ru/lk/order/event/PROD/3.1.0",
            "rootElement": "eventServiceResponse"
        }
    ],
    "Type": "PGU"
});
db.SmevMember.insert({
    _id: 12,
    "CertificateHash": "58fa1160a42ff3a97da4af269c2f9b63",
    "FtpUserPassword": "FNSR",
    "HumanReadableName": "ФНС России",
    "Mnemonic": "FNSR",
    "MpcRegistrationList": [
        {
            "namespace": "urn://x-artefacts-fns-SRCHIS/082-2/4.0.1",
            "rootElement": "RequestDocument"
        },
        {
            "namespace": "urn://x-artefacts-fns-SRCHIS/082-2/4.0.1",
            "rootElement": "ResponseDocument"
        },
        {
            "namespace": "urn://x-artefacts-fns-sprispnp/root/085-09/4.1.0",
            "rootElement": "SPRISPNPRequest"
        },
        {
            "namespace": "urn://x-artefacts-fns-sprispnp/root/085-09/4.1.0",
            "rootElement": "SPRISPNPResponse"
        },
        {
            "namespace": "urn://x-artefacts-fns-faktupnal/root/085-01/4.0.0",
            "rootElement": "FAKTUPNALRequest"
        },
        {
            "namespace": "urn://x-artefacts-fns-faktupnal/root/085-01/4.0.0",
            "rootElement": "FAKTUPNALResponse"
        }
    ],
    "Type": "OIV"
})

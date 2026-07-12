# springboot-logicore

Logistic Management system :

Schema design :-––––––––––

                           +----------------+
                           |    Customer    |
                           +----------------+
                           | customerId (PK)|
                           | name           |
                           | email          |
                           | phone          |
                           +----------------+
                                   |
                              1
                                   |
                                   |  One Customer
                                   |  can create
                                   |  many shipments
                                   |
                              *
                           +----------------+
                           |    Shipment    |
                           +----------------+
                           | shipmentId(PK) |
                           | source         |
                           | destination    |
                           | status         |
                           | createdDate    |
                           | customer_id(FK)|
                           | warehouse_id   |
                           | agent_id       |
                           +----------------+
                           /      |       \
                          /       |        \
                     1:1 /        |1:N      \ N:1
                        /         |          \
                       /          |           \
          +-----------+      +------------------+      +------------------+
          | Payment   |      | TrackingHistory  |      | DeliveryAgent    |
          +-----------+      +------------------+      +------------------+
          | paymentId |      | trackingId       |      | agentId          |
          | amount    |      | location         |      | name             |
          | method    |      | status           |      | contact          |
          | status    |      | time             |      | vehicleNumber    |
          |shipmentFK |      | shipmentFK       |      | availability     |
          +-----------+      +------------------+      +------------------+

                 |
                 |
              1:1|
                 |
        +----------------+
        | PackageEntity  |
        +----------------+
        | packageId      |
        | weight         |
        | dimensions     |
        | type           |
        | shipmentFK     |
        +----------------+

                         N:1
                          |
                          |
                  +----------------+
                  |   Warehouse    |
                  +----------------+
                  | warehouseId    |
                  | name           |
                  | location       |
                  | capacity       |
                  +----------------+
                  
                  
                  
                  
                  
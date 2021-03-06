package com.cloud9ers.director

import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.Service
import java.net.InetSocketAddress
import org.apache.thrift.protocol.TBinaryProtocol
import com.twitter.finagle.thrift.{ThriftClientFramedCodec, ThriftClientRequest}

object UcClientDemo {
  def main(args: Array[String]) {
    // Create a raw Thrift client service. This implements the
    // ThriftClientRequest => Future[Array[Byte]] interface.
    println("Creating Client...")
    val service: Service[ThriftClientRequest, Array[Byte]] = ClientBuilder()
      .hosts(new InetSocketAddress("localhost", 9999))
      .codec(ThriftClientFramedCodec())
      .hostConnectionLimit(1)
      .build()

    // Wrap the raw Thrift service in a Client decorator. The client
    // provides a convenient procedural interface for accessing the Thrift
    // server.
    val client = new LabsDirector.FinagledClient(service, new TBinaryProtocol.Factory())

    client.freeze("Koko Wawa") onSuccess { response =>
      println("Received response: " + response)
    } ensure {
      service.release()
    }
  }
}